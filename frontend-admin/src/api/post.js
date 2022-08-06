import {client} from './client.js';

export async function post(url = '', body) {
  return client(url, {
    method: 'POST',
    body: JSON.stringify(body),
    headers: {
      'Content-Type': 'application/json'
    }
  })
}
