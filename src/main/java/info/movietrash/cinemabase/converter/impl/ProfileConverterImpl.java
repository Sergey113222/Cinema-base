package info.movietrash.cinemabase.converter.impl;

import info.movietrash.cinemabase.converter.ProfileConverter;
import info.movietrash.cinemabase.dto.ProfileDto;
import info.movietrash.cinemabase.model.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileConverterImpl implements ProfileConverter {
    @Override
    public Profile toModel(ProfileDto profileDto) {
        Profile profile = new Profile();
        profile.setAvatar(profileDto.getAvatar());
        profile.setAbout(profileDto.getAbout());
        profile.setEmail(profileDto.getEmail());
        profile.setFirstName(profileDto.getFirstName());
        profile.setLastName(profileDto.getLastName());
        profile.setAge(profileDto.getAge());
        profile.setGender(profileDto.getGender());
        profile.setRegion(profileDto.getRegion());
        profile.setLanguage(profileDto.getLanguage());
        return profile;
    }

    @Override
    public ProfileDto toDto(Profile profile) {
        ProfileDto profileDto = new ProfileDto();
        profileDto.setAvatar(profile.getAvatar());
        profileDto.setAbout(profile.getAbout());
        profileDto.setEmail(profile.getEmail());
        profileDto.setFirstName(profile.getFirstName());
        profileDto.setLastName(profile.getLastName());
        profileDto.setAge(profile.getAge());
        profileDto.setGender(profile.getGender());
        profileDto.setRegion(profile.getRegion());
        profileDto.setLanguage(profile.getLanguage());
        return null;
    }
}
