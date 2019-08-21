package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Article
 */
@Data
@AllArgsConstructor @NoArgsConstructor
public class Article {

    private String id;
    private String author;
    private String url;
}
