package net.selfdotlearn.example;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FooTest {
    @Test
    public void shouldEqual() {
        assertThat(1).isEqualTo(1);
    }
}
