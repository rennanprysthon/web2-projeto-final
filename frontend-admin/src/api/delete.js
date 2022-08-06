import {client} from './client.js';

// porque delete é uma palavra reservada
export async function drop(url = '') {
  return client(url, {
    method: 'DELETE',
    header: {
      'Content-Type': 'application/json'
    }
  })
}
