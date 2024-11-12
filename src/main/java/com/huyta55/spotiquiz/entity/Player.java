package com.huyta55.spotiquiz.entity;

import jakarta.persistence.*;

@Entity
@Table(name="player")
public class Player {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="score")
    private Integer score = 0;

    @Column(name="high_score")
    private Integer highScore = 0;

    @Column(name="user_pswd")
    private String userPassword;

    @Column(name="dm_indicator")
    private Boolean dmIndicator = false;


    public Player() {
    }

    public Player(String username, String email, Integer score, Integer highScore, String passwd, Boolean dmIndicator) {
        this.username = username;
        this.email = email;
        this.score = score;
        this.highScore = highScore;
        this.userPassword = passwd;
        this.dmIndicator = dmIndicator;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getHighScore() {
        return highScore;
    }

    public void setHighScore(Integer highScore) {
        this.highScore = highScore;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Boolean getDmIndicator() {
        return dmIndicator;
    }

    public void setDmIndicator(Boolean dmIndicator) {
        this.dmIndicator = dmIndicator;
    }

    @Override
    public String toString() {
        return "Player{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", score=" + score +
                ", highScore=" + highScore +
                '}';
    }
}
