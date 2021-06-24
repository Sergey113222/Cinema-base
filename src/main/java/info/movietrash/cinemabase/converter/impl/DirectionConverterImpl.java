package info.movietrash.cinemabase.converter.impl;

import info.movietrash.cinemabase.converter.DirectionConverter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class DirectionConverterImpl implements DirectionConverter {

    @Override
    public Sort.Direction replaceStringThroughDirection(String sortDirection) {
        if (sortDirection.equalsIgnoreCase("DESC")) {
            return Sort.Direction.DESC;
        } else {
            return Sort.Direction.ASC;
        }
    }
}
