package com.example.demo.baza.danych;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;

@Document("Tasks")
public class Tasks {
    @Id
    @Field(name = "id_task")
    private Long idTask;
    @Field(name = "topic")
    private String topic;
    @Field(name = "topic_description")
    private String topicDescription;
    @Field(name = "topic_comment")
    private String topicComment;
    @Field(name = "last_date_of_change")
    private Timestamp lastDateOfChange;
    @Field(name = "who_changed_last")
    private String whoChangedLast;
    @Field(name = "deadline")
    private Timestamp deadline;

    public Tasks(Long idTask, String topic, String topicDescription, String topicComment, Timestamp lastDateOfChange, String whoChangedLast, Timestamp deadline) {
        this.idTask = idTask;
        this.topic = topic;
        this.topicDescription = topicDescription;
        this.topicComment = topicComment;
        this.lastDateOfChange = lastDateOfChange;
        this.whoChangedLast = whoChangedLast;
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "idTask=" + idTask +
                ", topic='" + topic + '\'' +
                ", topicDescription='" + topicDescription + '\'' +
                ", topicComment='" + topicComment + '\'' +
                ", lastDateOfChange=" + lastDateOfChange +
                ", whoChangedLast='" + whoChangedLast + '\'' +
                ", deadline=" + deadline +
                '}';
    }

    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    public String getTopicComment() {
        return topicComment;
    }

    public void setTopicComment(String topicComment) {
        this.topicComment = topicComment;
    }

    public Timestamp getLastDateOfChange() {
        return lastDateOfChange;
    }

    public void setLastDateOfChange(Timestamp lastDateOfChange) {
        this.lastDateOfChange = lastDateOfChange;
    }

    public String getWhoChangedLast() {
        return whoChangedLast;
    }

    public void setWhoChangedLast(String whoChangedLast) {
        this.whoChangedLast = whoChangedLast;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }
}
