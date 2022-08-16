package com.example.payment.exception;


public class SuccessCodeWithErrorResponse extends RuntimeException {

  private ErrorResponse errorResponse;

  private String id;


  public SuccessCodeWithErrorResponse(String id, ErrorResponse errorResponse) {
    this.id = id;
    this.errorResponse = errorResponse;
  }

  public SuccessCodeWithErrorResponse(ErrorResponse errorResponse) {
    this.errorResponse = errorResponse;
  }

  public ErrorResponse getErrorResponse() {
    return errorResponse;
  }

  public String getId() {
    return id;
  }
}

