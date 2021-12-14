package com.project.employeemanager.utils;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Component
public class UrlValidator implements Predicate<String> {

    @Override
    public boolean test(String url) {

        Pattern urlPattern = Pattern.compile("(http[s]?:\\/\\/)?([^\\/\\s]+\\/)(.*)");
        if(!(urlPattern.matcher(url).matches())){
            return false;
        }
        return true;
    }
}
