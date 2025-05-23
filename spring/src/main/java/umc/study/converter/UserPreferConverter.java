package umc.study.converter;

import umc.study.domain.Category;
import umc.study.domain.mapping.Preference;

import java.util.List;
import java.util.prefs.Preferences;
import java.util.stream.Collectors;

import static umc.study.domain.QCategory.category;

public class UserPreferConverter {

    public static List<Preference> toUserPreferList(List<Category> categoryList){

        return categoryList.stream()
                .map(category ->
                        Preference.builder()
                                .category(category)
                                .build()
                ).collect(Collectors.toList());
    }
}
