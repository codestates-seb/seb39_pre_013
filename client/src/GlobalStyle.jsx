import { createGlobalStyle } from 'styled-components';

const GlobalStyle = createGlobalStyle`
    *,
    *::before,
    *::after {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }

    body {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        color: hsl(210, 4%, 95%);
        min-height: 100vh;
        background-color: #3d3d3d;
    }
`;

export default GlobalStyle;
