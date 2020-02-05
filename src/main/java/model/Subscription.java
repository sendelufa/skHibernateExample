package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Subscriptions")
public class Subscription {

  @EmbeddedId
  private PK id;

  @Column(name = "student_id", insertable = false, updatable = false)
  private int studentId;

  @Column(name = "course_id", insertable = false, updatable = false)
  private int courseId;

  @Column(name = "subscription_date")
  private Date subscriptionDate;


  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public Date getSubscriptionDate() {
    return subscriptionDate;
  }

  public void setSubscriptionDate(Date subscriptionDate) {
    this.subscriptionDate = subscriptionDate;
  }


  @Embeddable
  public static class PK implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;


    public PK(Student student, Course course) {
      this.student = student;
      this.course = course;
    }

    public PK() {
    }


    public Student getStudent() {
      return student;
    }

    public Course getCourse() {
      return course;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      PK pk = (PK) o;
      return Objects.equals(getStudent(), pk.getStudent()) &&
          Objects.equals(getCourse(), pk.getCourse());
    }

    @Override
    public int hashCode() {
      return Objects.hash(getStudent(), getCourse());
    }
  }
}



