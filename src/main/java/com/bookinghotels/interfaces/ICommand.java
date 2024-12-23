package com.bookinghotels.interfaces;

public interface ICommand<T> {
  T execute();
}
