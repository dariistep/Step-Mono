/*package src.test.java;

import com.example.model.User;
import com.example.view.RegistrationView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegistrationControllerTest {
    private RegistrationView view;
    private RegistrationController controller;

    @BeforeEach
    void setUp() {
        view = mock(RegistrationView.class);
        controller = new RegistrationController(view);
    }

    @Test
    void testRegisterUser() {
        // Arrange
        when(view.getNameInput()).thenReturn("John");
        when(view.getSurnameInput()).thenReturn("Doe");
        when(view.getEmailInput()).thenReturn("john.doe@example.com");
        when(view.getPasswordInput()).thenReturn("password123");

        // Act
        controller.registerUser();

        // Assert
        User user = controller.getUser();
        assertNotNull(user);
        assertEquals("John", user.getName());
        assertEquals("Doe", user.getSurname());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertNotNull(user.getDateRegister());
    }
}*/