export class ApiResponse<T> {
  status: string;
  timestamp: string;
  data: T;

  constructor(status: string, timestamp: string, data: T) {
    this.status = status;
    this.timestamp = timestamp;
    this.data = data;
  }
}
