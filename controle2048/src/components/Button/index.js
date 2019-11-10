import React from 'react';
import {
    View,
    Text,
    TouchableOpacity,
    StyleSheet,
} from 'react-native'
import { sendDirection } from '../../services/control';

export default function Button(props) {
    return (
        <>
            <TouchableOpacity 
                style={[styles.container, props.style]} 
                onPress={async ()=> { await sendDirection(props.host, props.params.direction, props.params.name) }}
            >
                <Text style={{textAlign: 'center'}}>{props.text}</Text>
            </TouchableOpacity>
        </>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        width: 50,
        maxHeight: 50,
        maxWidth: 50,
        height: 50,
        backgroundColor: '#0f0',
    }
})
