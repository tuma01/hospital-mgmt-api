package com.amachi.app.hospitalappservice.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;

public abstract class AppUtils {

    private AppUtils() {}

    public static Sort getSort(String sort, String defaultSort) {
        Sort sorting  = Sort.by(AppConstants.DEFAULT_SORT_DIRECTION, defaultSort);
        if(StringUtils.isNotEmpty(sort)) {
            sorting  = Sort.by(AppConstants.DEFAULT_SORT_DIRECTION, sort);
        }
        return sorting;
    }
}
