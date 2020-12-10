package vcs.com.project.dto;

import lombok.Data;

@Data
public class GetSingleDataResponse<T> extends BaseResponse {
    private T data;

    private void setSuccess(T data) {
        super.setSuccess();
        this.data = data;
    }

    public void setResult(T data) {
        if (data != null) {
            this.setSuccess(data);
        } else {
            super.setFailed();
        }
    }

    @Override
    public String toString() {
        return "GetSingleDataResponse {" +
                "data = " + data +
                ", message = " + message + '\'' +
                "code = " + code +
                "}";
    }
}
