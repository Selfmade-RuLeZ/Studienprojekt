import { Button, Card, CardContent, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle, Grid, SpeedDial, SpeedDialIcon, TextField, Typography } from '@mui/material';
import { Container } from '@mui/system';
import React, { useEffect, useState } from 'react'

type Props = {}

function Cars({ }: Props) {

    const [data, setData] = useState<Car[] | undefined>(undefined)
    const [modalOpen, setModal] = useState(false);
    const [isLoading, setLoading] = useState(false);

    const handleClickOpen = () => {
        setModal(true);
    }

    const handleClose = () => {
        setModal(false);
    }

    useEffect(() => {
        setLoading(true);
        fetch(`${process.env.NEXT_PUBLIC_BACKEND_URL || ""}/api/cars`).then((res) => res.json())
            .then((data: Car[]) => {
                setData(data)
                setLoading(false)
            })
    }, [])

    if (isLoading) return (<div>Loading</div>)
    if (!data) return <p>No profile data</p>

    return (
        <Container>
            <Grid container sx={{ flexGrow: 1 }} spacing={2} justifyContent="center" padding={5}>
                {data.map(car =>
                    <Grid item xs={3} key={car.id}>
                        <Card>
                            <CardContent>
                                <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                                    {car.manufacturer.name}
                                </Typography>
                                <Typography variant="h5" component="div">
                                    {`${car.modelSeries} ${car.model}`}
                                </Typography>
                                <Typography variant="body2">
                                    Mileage: {`${car.mileage}`}
                                    <br />
                                    Motorization: {`${car.motorization}`}
                                    <br />
                                    VIN: {`${car.vin}`}
                                </Typography>
                            </CardContent>
                        </Card>
                    </Grid>)}

            </Grid>
            <SpeedDial
                ariaLabel="Add car"
                sx={{ position: 'absolute', bottom: 16, right: 16 }}
                icon={<SpeedDialIcon />}
                onClick={handleClickOpen}
            />

            <Dialog open={modalOpen} onClose={handleClose}>
                <DialogTitle>Add new Car</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        Fill your information to add a new car
                    </DialogContentText>
                    <TextField
                        autoFocus
                        margin="dense"
                        id="name"
                        label="Email Address"
                        type="email"
                        fullWidth
                        variant="standard"
                    />
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose}>Cancel</Button>
                    <Button onClick={handleClose}>Subscribe</Button>
                </DialogActions>
            </Dialog>

        </Container>
    )
}

export default Cars