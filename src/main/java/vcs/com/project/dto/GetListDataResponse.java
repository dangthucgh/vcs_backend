package vcs.com.project.dto;

import lombok.Data;
import java.util.List;

@Data
public class GetListDataResponse<T> extends BaseResponse {
    private List<T> listData;
    private Long totalRows = 0L;
    private Integer totalPages = 0;

    private void setSuccess(List<T> listData, Long totalRows, Integer totalPages) {
        super.setSuccess();
        this.listData = listData;
        this.totalRows = totalRows;
        this.totalPages = totalPages;
    }

    public void setResult(List<T> listData, Long totalRows, Integer totalPages) {
        if (listData != null) {
            this.setSuccess(listData, totalRows, totalPages);
        } else {
            super.setFailed();
        }
    }

    @Override
    public String toString() {
        return "GetListDataResponse { " +
                "datas = " + listData +
                ", totalRows = " + totalRows +
                ", totalPage = " + totalPages +
                " }";
    }
}
