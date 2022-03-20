package ru.stqa.pfd.addressbook;

import java.util.Objects;

public final class GroupData {
    private final String name;
    private final String label;
    private final String namber;

    public GroupData(String name, String label, String namber) {
        this.name = name;
        this.label = label;
        this.namber = namber;
    }

    public String name() {
        return name;
    }

    public String label() {
        return label;
    }

    public String namber() {
        return namber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (GroupData) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.label, that.label) &&
                Objects.equals(this.namber, that.namber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, label, namber);
    }

    @Override
    public String toString() {
        return "GroupData[" +
                "name=" + name + ", " +
                "label=" + label + ", " +
                "namber=" + namber + ']';
    }

}