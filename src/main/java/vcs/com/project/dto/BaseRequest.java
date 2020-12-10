package vcs.com.project.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class BaseRequest implements Serializable {
    private Integer pageNumber;
    private Integer pageSize;
}
