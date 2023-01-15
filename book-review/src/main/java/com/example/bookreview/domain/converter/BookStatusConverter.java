package com.example.bookreview.domain.converter;

import com.example.bookreview.repository.dto.BookStatusDto;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BookStatusConverter implements AttributeConverter<BookStatusDto, Integer> {

    @Override
    public Integer convertToDatabaseColumn(BookStatusDto attribute) {
        return attribute.getCode();
    }

    @Override
    public BookStatusDto convertToEntityAttribute(Integer dbData) {
        return dbData != null ? new BookStatusDto(dbData) : null;
    }
}
