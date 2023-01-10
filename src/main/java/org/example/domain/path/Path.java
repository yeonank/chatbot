package org.example.domain.path;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Path {
    @Id
    @Column(length = 50, nullable = false)
    private String directory_name;


    @Column(length = 150, nullable = false)
    private String directory_path;

    @Builder
    public Path(String directory_name, String directory_path){
        this.directory_name = directory_name;
        this.directory_path = directory_path;
    }
}
