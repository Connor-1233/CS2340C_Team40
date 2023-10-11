package com.example.cs2340c_team40;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.cs2340c_team40.View.ConfigScreen;
import com.example.cs2340c_team40.ViewModel.ConfigScreenViewModel;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
        @Test
        public void testNameValidator_NullName() {
            String name = null;
            assertFalse(ConfigScreenViewModel.isValidName(name));
        }

        @Test
        public void testNameValidator_EmptyName() {
            String name = "";
            assertFalse(ConfigScreenViewModel.isValidName(name));
        }

        @Test
        public void testNameValidator_WhitespaceName() {
            String name = "    ";
            assertFalse(ConfigScreenViewModel.isValidName(name));
        }

        @Test
        public void testNameValidator_ValidName() {
            String name = "John Doe";
            assertTrue(ConfigScreenViewModel.isValidName(name));
        }

}