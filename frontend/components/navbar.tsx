import React from 'react'
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';

type Props = {}

const NavBar = (props: Props) => {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
        <Typography
            variant="h6"
            component="a"
            href="/"
            sx={{ mr: 2 }}
          >
            Car-Management
          </Typography>
          <Typography variant="h6" component="a" href="/cars">
            Cars
          </Typography>
        </Toolbar>
      </AppBar>
    </Box>
  )
}

export default NavBar