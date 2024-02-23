package com.nhnacademy.minidooray.taskapi.domain;

import com.nhnacademy.minidooray.taskapi.enums.AuthType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project_members")
public class ProjectMember {

    @EmbeddedId
    private Pk pk;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(name = "project_id")
    private Project projectId;

    @Column(name = "auth_type")
    @Enumerated(EnumType.STRING)
    private AuthType authType;

    @OneToMany(mappedBy = "projectMember")
    private List<Task> tasks = new ArrayList<>();

    @Getter
    @Setter
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pk implements Serializable {

        @Column(name = "member_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String memberId;

        private Integer projectId;
    }
}
