package k25.vk2.domain;

public class Friend {
    String firstName, lastName;

    public Friend(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Friend() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Friend [firstName=" + firstName + ", lastName=" + lastName + "]";
    }

}
