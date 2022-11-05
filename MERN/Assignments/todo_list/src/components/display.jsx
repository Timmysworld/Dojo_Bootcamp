import React from 'react'
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import DeleteTwoToneIcon from '@mui/icons-material/DeleteTwoTone';

const Display = ({list,setList}) => {
    const change = (e) => {
        // change value isong !
        e.complete = !e.complete;
        // update list
        let update = [...list];
        // change list state to updated list
        setList(update);
    }

    // if button is clicked
    // use filter to remove item from the list
    const deleteMe = val => {
        //                                () does not need return
        setList( list.filter( (item, i) => (item.content !== val) ) );
    }

    return (
        <div className='FormResults'>
        <TableContainer 
            component={Paper} 
            variant="outlined">
            <Table aria-label="demo table">
                <TableHead>
                    <TableRow>
                        <TableCell>Tasks</TableCell>
                        <TableCell>Actions</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {/* get every object in the list */}
                    {list.map( (item, index) =>
                        <TableRow>
                            <TableCell>
                                <span className={(item.complete)? "complete":null}>
                                    {item.content}
                                </span>
                            </TableCell>

                            <TableCell>
                            <input type="checkbox" className='check' onChange={ e => change(item) }/> | 
                            <button className='smallBtn' onClick={ e => deleteMe(item.content) }> <DeleteTwoToneIcon />
                            </button>
                        </TableCell>

                    </TableRow>
                    )}
                    
                    <TableRow>                    
                    </TableRow>
                </TableBody>
            </Table>
        </TableContainer>
        </div>
    )
}

export default Display


