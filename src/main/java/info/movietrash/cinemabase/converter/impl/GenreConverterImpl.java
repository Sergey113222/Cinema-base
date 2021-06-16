package info.movietrash.cinemabase.converter.impl;

import info.movietrash.cinemabase.converter.GenreConverter;
import info.movietrash.cinemabase.dto.ExternalGenreDto;
import info.movietrash.cinemabase.model.Genre;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreConverterImpl implements GenreConverter {
    @Override
    public List<Genre> toModel(List<ExternalGenreDto> externalGenreDtoList) {

        return externalGenreDtoList.stream().map(externalGenreDto -> {
            Genre genre = new Genre();
            genre.setId(externalGenreDto.getExternalId());
            genre.setName(externalGenreDto.getName());
            return genre;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ExternalGenreDto> toDto(List<Genre> genreList) {

        return genreList.stream().map(genre -> {
            ExternalGenreDto externalGenreDto = new ExternalGenreDto();
            externalGenreDto.setExternalId(genre.getExternalId());
            externalGenreDto.setName(genre.getName());
            return externalGenreDto;
        }).collect(Collectors.toList());
    }
}
