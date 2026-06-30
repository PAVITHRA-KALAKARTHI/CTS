package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ServiceTest {

    @Test
    public void testServiceWithMockRepository() {

        // Create Mock Repository
        Repository mockRepository = mock(Repository.class);

        // Stub Method
        when(mockRepository.getData()).thenReturn("Mock Data");

        // Inject Mock Repository
        Service service = new Service(mockRepository);

        // Call Service Method
        String result = service.processData();

        // Verify Result
        assertEquals("Processed Mock Data", result);

    }

}