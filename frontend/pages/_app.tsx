import '../styles/globals.css'
import type { AppProps } from 'next/app'
import Head from 'next/head'
import NavBar from '../components/navbar'

function MyApp({ Component, pageProps }: AppProps) {
  return (
      <>
        <NavBar />
        <Component {...pageProps} />
      </>
    )
}

export default MyApp
