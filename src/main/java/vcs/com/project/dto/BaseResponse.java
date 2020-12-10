package vcs.com.project.dto;

import lombok.Data;
import vcs.com.project.Util.Constants;

@Data
public class BaseResponse {
    protected String message;
    protected String code;

    public void setSuccess() {
        this.code = Constants.ApiErrorCode.SUCCESS;
        this.message = Constants.ApiErrorDesc.SUCCESS;
    }

    public void setSuccess(String msg) {
        this.code = Constants.ApiErrorCode.SUCCESS;
        this.message = msg;
    }

    public void setFailed() {
        this.code = Constants.ApiErrorCode.ERROR;
        this.message = Constants.ApiErrorDesc.ERROR;
    }

    public void setFailed(String code, String msg) {
        this.code = code;
        this.message = msg;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
