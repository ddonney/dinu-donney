package com.automation.api.helpers;

import org.junit.Assert;
/**
 * @author dinudonney
 * @Date 07/07/22
 */
public class FieldValueHelper {
    public static void assertFields(String assertionType, String field, String expectedValue, Object actualValue) {
        switch (assertionType) {
            case "non-null":
                Assert.assertFalse("field : " + field + "is empty", actualValue.toString().isEmpty());
                break;

            case "equals":
                Assert.assertEquals("field : " + field + "value is not as expected. ", expectedValue, actualValue);
                break;
        }
    }
}