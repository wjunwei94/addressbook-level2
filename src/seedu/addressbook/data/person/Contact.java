package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

    public final String value;
    public final String validationRegex;
    private boolean isPrivate;
	  
    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Contact(String contact, boolean isPrivate, String messageConstraint, String validationRegex) throws IllegalValueException {
        String trimmedContact = contact.trim();
        this.isPrivate = isPrivate;
        this.validationRegex = validationRegex;
        if (!isValidContact(trimmedContact)) {
            throw new IllegalValueException(messageConstraint);
        }
        this.value = trimmedContact;
    }
    
    /**
     * Returns true if a given string is a valid contact.
     */
    public boolean isValidContact(String test) {
        return test.matches(validationRegex);
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
