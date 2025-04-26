package app.torbox.torbox.validation.validators.modelValidators;

import app.torbox.torbox.validation.Violation;
import app.torbox.torbox.validation.validators.AbstractValidator;
import java.util.Arrays;

public abstract class AbstractModelValidator<T> extends AbstractValidator<T> {

  public AbstractModelValidator(String fieldName) {
    super(fieldName);
  }

  public AbstractModelValidator() {}

  protected abstract Violation[] validateModel(T value);

  @Override
  public Violation[] validate(T value) {
    Violation requiredViolation = validateRequired(value);
    if (requiredViolation != null) {
      return new Violation[] { requiredViolation };
    }
    if (value == null) {
      return new Violation[0];
    }

    Violation[] violations = validateModel(value);
    if (violations.length == 0) {
      return violations;
    }

    return Arrays.stream(violations)
      .map(violation -> {
        String newPath = violation.getPath().isEmpty()
          ? getFieldName()
          : String.format("%s.%s", getFieldName(), violation.getPath());
        return new Violation(newPath, violation.getMessage());
      })
      .toArray(Violation[]::new);
  }
}
