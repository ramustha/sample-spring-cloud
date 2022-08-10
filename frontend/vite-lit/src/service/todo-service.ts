import { Task } from '@lit-labs/task';
import { ReactiveControllerHost } from 'lit';

const BASE_URL =
  'https://jsonplaceholder.typicode.com';

export function getTodosAPI(
  host: ReactiveControllerHost,
  size: Number
): Task {
  return new Task(
    host,
    ([size]) =>
      fetch(`${BASE_URL}/todos?_limit=${size}`).then(
        (res) => res.json()
      ),
    () => [size]
  );
}
