package app.torbox.torbox.validation.validators;

import app.torbox.torbox.validation.Violation;

public interface Validator<T> {
  Violation[] validate(T value);
}
