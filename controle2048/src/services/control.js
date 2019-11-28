import axios from 'axios';

export async function sendDirection(host, direction, name) {
    try {
        await axios.post(`http://${host}/control`, { direction, object: { name } });
    } catch(err) {
        console.log(err);
    }
}