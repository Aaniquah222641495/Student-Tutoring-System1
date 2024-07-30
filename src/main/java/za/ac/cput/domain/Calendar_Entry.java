package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.Date;
@Deprecated
@Entity
public class Calendar_Entry {
    @Id
    private Integer entry_id;
    private Date date;
    private String title;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student_id;
    @OneToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor_id;
    private String subject_code;
    private String description;

    public Calendar_Entry() {

    }

    private Calendar_Entry(Builder builder) {
        this.entry_id = builder.entry_id;
        this.date = builder.date;
        this.title = builder.title;
        this.student_id = builder.student_id;
        this.tutor_id = builder.tutor_id;
        this.subject_code = builder.subject_code;
        this.description = builder.description;
    }

    public Integer getEntry_id() {
        return entry_id;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public Student getStudent_id() {
        return student_id;
    }

    public Tutor getTutor_id() {
        return tutor_id;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Calendar_Entry{" +
                "entry_id=" + entry_id +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", student_id=" + student_id +
                ", tutor_id=" + tutor_id +
                ", subject_code='" + subject_code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {
        private Integer entry_id;
        private Date date;
        private String title;
        private Student student_id;
        private Tutor tutor_id;
        private String subject_code;
        private String description;

        public Builder setEntry_id(Integer entry_id) {
            this.entry_id = entry_id;
            return this;
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setStudent_id(Student student_id) {
            this.student_id = student_id;
            return this;
        }

        public Builder setTutor_id(Tutor tutor_id) {
            this.tutor_id = tutor_id;
            return this;
        }

        public Builder setSubject_code(String subject_code) {
            this.subject_code = subject_code;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        public Calendar_Entry build() {
            return new Calendar_Entry(this);
        }
    }
}
