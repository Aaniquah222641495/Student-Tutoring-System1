package za.ac.cput.domain;

import java.util.Arrays;
import java.util.Objects;

public class Subject {
    private String subjectCode;
    private String name;
    private byte[] subjectGuide;

    public Subject() {
    }

    public Subject(Builder builder) {
        this.subjectCode = builder.subjectCode;
        this.name = builder.name;
        this.subjectGuide = builder.subjectGuide;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getName() {
        return name;
    }

    public byte[] getSubjectGuide() {
        return subjectGuide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(subjectCode, subject.subjectCode) && Objects.equals(name, subject.name) && Arrays.equals(subjectGuide, subject.subjectGuide);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(subjectCode, name);
        result = 31 * result + Arrays.hashCode(subjectGuide);
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectCode='" + subjectCode + '\'' +
                ", name='" + name + '\'' +
                ", subjectGuide=" + Arrays.toString(subjectGuide) +
                '}';
    }

    public static class Builder{
        private String subjectCode;
        private String name;
        private byte[] subjectGuide;

        public Builder setSubjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSubjectGuide(byte[] subjectGuide) {
            this.subjectGuide = subjectGuide;
            return this;
        }

        public Builder copy(Subject subject){
            this.subjectCode = subject.getSubjectCode();
            this.name = subject.getName();
            this.subjectGuide = subject.getSubjectGuide();
            return this;
        }

        public Subject build(){
            return new Subject(this);
        }
    }
}
