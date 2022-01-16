import { render, screen } from '@testing-library/react';
import App from './App';

test('renders tasks heading', () => {
    render(<App />);
    const linkElement = screen.getByText(/tasks app/i);
    expect(linkElement).toBeInTheDocument();
});
