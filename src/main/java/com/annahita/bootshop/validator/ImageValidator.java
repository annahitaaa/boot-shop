package com.annahita.bootshop.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class ImageValidator implements ConstraintValidator<ValidImage, MultipartFile> {
    private boolean optional;

    @Override
    public void initialize(ValidImage constraintAnnotation) {
        this.optional = constraintAnnotation.optional();
    }

    @Override
    public boolean isValid(MultipartFile image, ConstraintValidatorContext context) {
        if (optional && (image == null || image.isEmpty())) {
            return true;
        }
        if (image == null || image.isEmpty()) {
            return false;
        }
        String contentType = image.getContentType();
        if (contentType == null || !(contentType.equals("image/jpeg") || contentType.equals("image/png"))) {
            return false;
        }
        return image.getSize() <= 2 * 1024 * 1024;
    }
}

