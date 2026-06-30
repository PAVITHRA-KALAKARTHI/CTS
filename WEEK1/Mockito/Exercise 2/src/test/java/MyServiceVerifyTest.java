package org.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MyServiceVerifyTest {

    @Test
    public void testVerifyInteraction() {

        // Arrange
        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        // Act
        service.fetchData();

        // Assert (Verify Interaction)
        verify(mockApi).getData();

    }

}