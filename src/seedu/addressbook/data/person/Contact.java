package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
	
	public final String value;
	public final String validationRegex;
	private boolean isPrivate;
    
    public Contact(String string, boolean isPrivate, String messageConstraint, String validationRegex) throws IllegalValueException {
        String trimmedString = string.trim();
        this.isPrivate = isPrivate;
        this.validationRegex = validationRegex;
        if (!isValidContact(trimmedString)) {
            throw new IllegalValueException(messageConstraint);
        }
        this.value = trimmedString;
    }

    /**
     * Returns true if a given string is a valid email/address/phone.
     */
   
    public boolean isValidContact(String test) {
        return test.matches(validationRegex);
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }
	
	@Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
	
}
