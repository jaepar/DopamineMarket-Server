package Hackathon.DopamineMarket.domain.app.exception;

import Hackathon.DopamineMarket.global.response.status.ResponseStatus;

public class AppUrlFormatInvalidException extends RuntimeException {
  private final ResponseStatus exceptionStatus;

  public AppUrlFormatInvalidException(ResponseStatus exceptionStatus) {
    super(exceptionStatus.getMessage());
    this.exceptionStatus = exceptionStatus;
  }
}
