import {client} from './client.js';

export async function post(url = '', body) {
  return client(url, {
    method: 'POST',
    body: JSON.stringify(body),
    header: {
      'Content-Type': 'application/json'
    }
  })
}
