package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Subscriptions")
public class Subscription {

  @EmbeddedId
  private PK id;

  @Column(name = "student_id")
  private int studentId;

  @Column(name = "course_id")
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

}

@Embeddable
class PK implements Serializable {

  int course_Id;
  int student_Id;

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
    PK pk = (PK) o;
    return course_Id == pk.course_Id &&
        student_Id == pk.student_Id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(course_Id, student_Id);
  }
}



