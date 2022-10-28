package com.example.processor.service;

import csci318.demo.model.Appliance;
import csci318.demo.model.BrandQuantity;
import csci318.demo.model.Equipment;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.state.KeyValueStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Configuration
public class ProductStreamProcessing {

    public final static String SALE_STATE_STORE = "product-sales-store";
    public final static String PART_STATE_STORE = "part-store";

    @Bean
    public Function<KStream<?, Product>, KStream<String, ProductSales>> process() {
        return inputStream -> {

            inputStream.map((k, v) -> {
                String partName = v.getPart();
                String saleNumber = v.getSale();
                Part part = new Part();
                part.setPart(partName);
                part.setSale(saleNumber);
                String new_key = saleNumber + partName;
                return KeyValue.pair(new_key, part);
            }).toTable(
                    Materialized.<String, Part, KeyValueStore<Bytes, byte[]>>as(PART_STATE_STORE).
                            withKeySerde(Serdes.String()).
                            // a custom value serde for this state store
                                    withValueSerde(equipmentSerde())
            );

            KTable<String, Long> brandKTable = inputStream.
                    mapValues(Product::getBrand).
                    groupBy((keyIgnored, value) -> value).
                    count(
                            Materialized.<String, Long, KeyValueStore<Bytes, byte[]>>as(SALE_STATE_STORE).
                                    withKeySerde(Serdes.String()).
                                    withValueSerde(Serdes.Long())
                    );

            KStream<String, ProductSales> productSalesKStream = saleKTable.
                    toStream().
                    map((k, v) -> KeyValue.pair(k, new ProductSales(k, v)));
            // use the following code for testing
            productSalesKStream.print(Printed.<String, ProductSales>toSysOut().withLabel("Console Output"));

            return productSalesKStream;
        };
    }


    // Can compare the following configuration properties with those defined in application.yml
    public Serde<Part> equipmentSerde() {
        final JsonSerde<Part> partJsonSerde = new JsonSerde<>();
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(JsonDeserializer.VALUE_DEFAULT_TYPE, "com.example.processor.model.Aggregate.Part");
        configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        partJsonSerde.configure(configProps, false);
        return partJsonSerde;
    }
}
