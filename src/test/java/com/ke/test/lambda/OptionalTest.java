package com.ke.test.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Test;

public class OptionalTest {

	@Test
	public void optionalTest() {

		Optional<String> a = Optional.of("a");
		assertThat(a.get(), is("a"));

		Optional emptyOptional = Optional.empty();
		Optional alsoEmpty = Optional.ofNullable(null);

		assertThat(emptyOptional.isPresent(), is(false));
		assertThat(alsoEmpty.isPresent(), is(false));

		assertThat("b", is(emptyOptional.orElse("b")));
		assertThat("c", is(emptyOptional.orElseGet(() -> "c")));
		assertThat("a", is(a.orElse("b")));

	}

}
