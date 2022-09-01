/* eslint-disable react/destructuring-assignment */
/* eslint-disable react/no-children-prop */
import React from 'react';
import ReactMarkdown from 'react-markdown';
import remarkGfm from 'remark-gfm';
import rehypeKatex from 'rehype-katex';
import { Prism as SyntaxHighlighter } from 'react-syntax-highlighter';
import remarkMath from 'remark-math';
import 'katex/dist/katex.min.css';
import { vscDarkPlus } from 'react-syntax-highlighter/dist/esm/styles/prism';
import PropTypes from 'prop-types';
import styled from 'styled-components';
// gruvboxDark vscDarkPlus
export default function Markdown(props) {
  return (
    <Container>
      <ReactMarkdown
        children={props.text}
        components={{
          //   eslint-disable-next-line react/no-unstable-nested-components, no-shadow, object-curly-newline
          code({ node, inline, className, children, ...props }) {
            const match = /language-(\w+)/.exec(className || '');
            return !inline && match ? (
              <SyntaxHighlighter
                children={String(children).replace(/\n$/, '')}
                style={vscDarkPlus}
                language={match[1]}
                PreTag="div"
                // eslint-disable-next-line react/jsx-props-no-spreading
                {...props}
              />
            ) : (
              // eslint-disable-next-line react/jsx-props-no-spreading
              <code className={className} {...props}>
                {children}
              </code>
            );
          },
        }}
        remarkPlugins={[remarkGfm, remarkMath]}
        rehypePlugins={[rehypeKatex]}
      />
    </Container>
  );
}

Markdown.propsTypes = {
  children: PropTypes.node.isRequired,
};

const Container = styled.div`
  margin-top: 0.5rem;

  img {
    max-width: 100%;
  }
`;
